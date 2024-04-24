package br.gov.sp.fatec.apipixel.core.usecase.empresa;

import br.gov.sp.fatec.apipixel.core.domain.repository.EmpresaRepository;

public class DeletarEmpresaUC {

    private final EmpresaRepository empresaRepository;

    public DeletarEmpresaUC(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void deletarEmpresa(Long codigo) {
        empresaRepository.deletarPorCodigo(codigo);
    }
}
