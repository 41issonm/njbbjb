package br.gov.sp.fatec.apipixel.core.domain.repository;

import br.gov.sp.fatec.apipixel.core.domain.projection.EmpresaProjection;

import java.util.List;

public interface EmpresaRepository {

    List<EmpresaProjection> carregar();
}