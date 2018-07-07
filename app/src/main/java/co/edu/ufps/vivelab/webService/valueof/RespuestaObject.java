package co.edu.ufps.vivelab.webService.valueof;

public class RespuestaObject<T> {

    private String mensaje;

    private int codigoRespuesta;

    private String estado;

    private T data;

    public RespuestaObject() {
        // TODO Auto-generated constructor stub
    }

    public RespuestaObject(String mensaje, String estado, int codigoRespuesta) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.codigoRespuesta = codigoRespuesta;
    }

    public RespuestaObject(String mensaje, String estado, int codigoRespuesta, T data) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.codigoRespuesta = codigoRespuesta;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
