package br.gov.sp.fatec.apipixel.core.domain.projection;

public interface EmpresaProjection {
    Long getId();
    Long getCodigo();
    String getNome();
    String getCidade();
    String getPais();
    String getAdminNome();
    String getAdminEmail();
}
