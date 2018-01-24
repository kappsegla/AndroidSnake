package snowroller.myapplication.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import snowroller.myapplication.models.SkistarSummary;

/**
 * Created by Martin on 2018-01-24.
 */

public interface SkistarAPIService {

    @GET("statistic/summary")
    Call<SkistarSummary> summary(@Header("DisplayedEntityId") String skierId);
    @GET("friend/count")
    Call<Integer> friendCount(@Header("DisplayedEntityId") String skierId);
}
/*
https://www.skistar.com/myskistar/game/api/v3/statistic/rides?seasonId=13
https://www.skistar.com/myskistar/game/api/v3/pins/latest?seasonId=13
https://www.skistar.com/myskistar/game/api/v3/statistic/active
https://www.skistar.com/myskistar/game/api/v3/statistic/summary
https://www.skistar.com/myskistar/game/api/v3/statistic/latest
https://www.skistar.com/myskistar/game/api/v3/friend/count
https://www.skistar.com/myskistar/game/api/v3/position
https://www.skistar.com/myskistar/game/api/v3/position/friend
https://www.skistar.com/myskistar/game/api/v3/leaderboard/friends/latest
*/