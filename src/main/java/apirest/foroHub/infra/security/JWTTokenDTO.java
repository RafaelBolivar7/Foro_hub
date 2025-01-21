package apirest.foroHub.infra.security;

public record JWTTokenDTO (String token) {
    public JWTTokenDTO (String token){
        this.token = token;
    }
}
