package br.gov.sp.fatec.apipixel.core.domain.repository;

import br.gov.sp.fatec.apipixel.core.domain.entity.Empresa;
import br.gov.sp.fatec.apipixel.core.domain.projection.EmpresaProjection;

import java.util.List;

public interface EmpresaRepository {

        List<EmpresaProjection> carregar();

        EmpresaProjection save(Empresa empresa);

        void deletarPorCodigo(Long codigo);

        EmpresaProjection atualizar(EmpresaProjection empresa);

        EmpresaProjection buscarPorCodigo(Long codigo);

        List<EmpresaProjection> buscarTodas();
    }
