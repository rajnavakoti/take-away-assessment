package utils.configuration

import static utils.configuration.PropertiesReader.getKey

/***
 * function calls to read 'configuration.groovy' file
 */
class Config {
    static boolean isLocal() {
        return getKey("executionEnvironment") == 'local' }

    static boolean isProd() {
        return getKey("environment") == 'prod' }

    static boolean isJenkins() {
        return getKey("executionEnvironment") == 'jenkins' }

    static getEnvironment() {
        return getKey("environment") }

    static getTheMovieDbAPIURL(){
        return getKey("theMovieDbApiUrl",getEnvironment()) }

    static getTheMovieDbAPiKey(){
        return getKey("theMovieDbApiKey",getEnvironment()) }

    static getTheMovieDbApiToken(){
        return getKey("theMovieDbApiToken",getEnvironment()) }

    static getTheMovieDbCreateToken(){
        return getKey("theMovieDbCreateToken",getEnvironment()) }

    static getTheMovieDbApiContentType(){
        return getKey("theMovieDbContentType",getEnvironment()) }
}
