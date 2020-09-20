package utils.configuration

class PropertiesReader {
    static private String configPath = '/configuration.groovy'

    static getKey(String key, String environment = null) {
        if (environment == null) {
            ConfigObject config = new ConfigSlurper()
                    .parse(ConfigSlurper.getResource(configPath))
            return config.getProperty(key) as String
        }

        ConfigObject config = new ConfigSlurper(environment: environment).parse(ConfigSlurper.getResource(configPath))
        def property = config.getProperty(key)
        if (property instanceof ConfigObject && property.isEmpty()) {
            ConfigObject configGlobal = new ConfigSlurper()
                    .parse(ConfigSlurper.getResource(configPath))
            def propertyGlobal = configGlobal.getProperty(key) as String
            if (propertyGlobal instanceof ConfigObject && property.isEmpty()) {
                throw new Exception("Incorrect configuration of the config. You are trying to get a key : \"" + key
                        + "\" which is not defined for an environment : " + environment)
            }
        }
        return property as String
    }
}
