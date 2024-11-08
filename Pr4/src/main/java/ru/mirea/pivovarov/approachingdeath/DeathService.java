package ru.mirea.pivovarov.approachingdeath;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface DeathService {
    @GET("/resource/2vr3-k9wn.json")
    Call<List<ApproachingDeathDTO>> getDate();
}
