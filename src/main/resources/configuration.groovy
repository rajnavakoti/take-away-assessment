//environment Variables
executionEnvironment = System.getenv("ENV_EXECUTION") ?: "local"
environment = System.getenv("TEST_ENVIRONMENT") ?: "prod"

environments {
    prod {
        theMovieDbApiUrl = "https://api.themoviedb.org"
        theMovieDbApiKey = "4133e6d52014a9ace0d2c6d5ce21e0a2"
        theMovieDbApiToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MTMzZTZkNTIwMTRhOWFjZTBkMmM2ZDVjZTIxZTBhMiIsInN1YiI6IjVmNjY3YTI2NTc1MzBlMDAzOGFiMDBjOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uEcjLYEeo4W2JsE2bgd-3m93Edjfrcq-W92SJjWbLVU"
        theMovieDbCreateToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE2MDA1OTkzMzIsInN1YiI6IjVmNjY3YTI2NTc1MzBlMDAzOGFiMDBjOCIsImp0aSI6IjI0MDMzNzEiLCJhdWQiOiI0MTMzZTZkNTIwMTRhOWFjZTBkMmM2ZDVjZTIxZTBhMiIsInNjb3BlcyI6WyJhcGlfcmVhZCIsImFwaV93cml0ZSJdLCJ2ZXJzaW9uIjoxfQ.R47XnaMLF1HoRxa9uV-xVB90TQVgIzzf4Cy76yBzQeA"
        theMovieDbContentType = "application/json"
    }
}