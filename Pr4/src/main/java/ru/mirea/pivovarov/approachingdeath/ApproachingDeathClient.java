package ru.mirea.pivovarov.approachingdeath;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ApproachingDeathClient {
    public static void main(String[] args) throws IOException {
        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://data.nasa.gov/")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();

        DeathService service = client.create(DeathService.class);

        Response<List<ApproachingDeathDTO>> response = service.getDate().execute();

        List<ApproachingDeathDTO> dto = response.body();

        dto.stream().max(new Comparator<ApproachingDeathDTO>() {
            @Override
            public int compare(ApproachingDeathDTO o1, ApproachingDeathDTO o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        }).ifPresent(o -> {System.out.println(o.getDate());});
    }
}
