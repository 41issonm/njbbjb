package br.gov.sp.fatec.apipixel.core.usecase.empresa;

import br.gov.sp.fatec.apipixel.core.domain.entity.Empresa;
import br.gov.sp.fatec.apipixel.core.domain.projection.EmpresaProjection;
import br.gov.sp.fatec.apipixel.core.domain.repository.EmpresaRepository;

public class AtualizarEmpresaUC {

    private final EmpresaRepository empresaRepository;

    public AtualizarEmpresaUC(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaProjection atualizarEmpresa(Long codigo, String novoNome, String novaCidade, String novoPais, String novoAdminNome, String novoAdminEmail) {
        Empresa empresaExistente = (Empresa) empresaRepository.buscarPorCodigo(codigo);
        if (empresaExistente != null) {
            empresaExistente.setNome(novoNome);
            empresaExistente.setCidade(novaCidade);
            empresaExistente.setPais(novoPais);
            empresaExistente.setAdminNome(novoAdminNome);
            empresaExistente.setAdminEmail(novoAdminEmail);
            return empresaRepository.salvar(empresaExistente);
        }
        return null; // ou lançar uma exceção, dependendo do comportamento desejado
    }
}
