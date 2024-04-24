package br.gov.sp.fatec.apipixel.core.usecase.empresa;

import br.gov.sp.fatec.apipixel.core.domain.entity.Empresa;
import br.gov.sp.fatec.apipixel.core.domain.projection.EmpresaProjection;
import br.gov.sp.fatec.apipixel.core.domain.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriarEmpresaUC {

    private final EmpresaRepository empresaRepository;

    public CriarEmpresaUC(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaProjection criarEmpresa(Long codigo, String nome, String cidade, String pais, String adminNome, String adminEmail) {
        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setCodigo(codigo);
        novaEmpresa.setNome(nome);
        novaEmpresa.setCidade(cidade);
        novaEmpresa.setPais(pais);
        novaEmpresa.setAdminNome(adminNome);
        novaEmpresa.setAdminEmail(adminEmail);

        empresaRepository.salvar(novaEmpresa);

    }
}
