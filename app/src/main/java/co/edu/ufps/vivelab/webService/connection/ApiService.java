package co.edu.ufps.vivelab.webService.connection;

import java.util.List;

import co.edu.ufps.vivelab.webService.valueof.RespuestaObject;
import co.edu.ufps.vivelab.webService.valueof.ConvocatoriaValue;
import co.edu.ufps.vivelab.webService.valueof.UsuarioValue;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 *
 */
public interface ApiService {

    @GET("convocatoria/movil/listar")
    Call<RespuestaObject<List<ConvocatoriaValue>>> getConvocatorias();

    @POST("usuario/login")
    Call<RespuestaObject<UsuarioValue>> login(@Body UsuarioValue user);

}
