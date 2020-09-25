package api.themoviedb.v2

import utils.configuration.Config

/***
 * Movie db API endpoints
 */
class theMovieDbEndPoints {
    static String THE_MOVIE_BD_API_URL = Config.getTheMovieDbAPIURL()

    public static final String EP_LIST = THE_MOVIE_BD_API_URL + "/4/list"}
