package br.gov.sp.fatec.apipixel.core.service;

import br.gov.sp.fatec.apipixel.core.domain.entity.Empresa;

public interface EmpresaService {
    Empresa cadastrarEmpresa(Empresa empresa);
    Empresa buscarEmpresaPorId(Long id);
}
