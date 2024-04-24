package br.gov.sp.fatec.apipixel.inbound.rest;

import br.gov.sp.fatec.apipixel.core.domain.entity.Empresa;
import br.gov.sp.fatec.apipixel.core.domain.projection.EmpresaProjection;
import br.gov.sp.fatec.apipixel.core.usecase.empresa.CarregarEmpresaUC;
import br.gov.sp.fatec.apipixel.core.usecase.empresa.CriarEmpresaUC;
import br.gov.sp.fatec.apipixel.core.usecase.empresa.DeletarEmpresaUC;
import br.gov.sp.fatec.apipixel.core.usecase.empresa.AtualizarEmpresaUC;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final CarregarEmpresaUC carregarEmpresaUC;
    private final CriarEmpresaUC criarEmpresaUC;
    private final DeletarEmpresaUC deletarEmpresaUC;
    private final AtualizarEmpresaUC atualizarEmpresaUC;

    @GetMapping
    public ResponseEntity<List<EmpresaProjection>> findAll(){
        return ResponseEntity.ok(carregarEmpresaUC.executar());
    }

    @PostMapping
    public ResponseEntity<EmpresaProjection> save(@RequestBody Empresa empresa){
        return ResponseEntity.ok(criarEmpresaUC.criarEmpresa(empresa.getCodigo(), empresa.getNome(), empresa.getCidade(), empresa.getPais(), empresa.getAdminNome(), empresa.getAdminEmail()));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable Long codigo){
        deletarEmpresaUC.deletarEmpresa(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<EmpresaProjection> update(@PathVariable Long codigo, @RequestBody Empresa empresa){
        return ResponseEntity.ok(atualizarEmpresaUC.atualizarEmpresa(codigo, empresa.getNome(), empresa.getCidade(), empresa.getPais(), empresa.getAdminNome(), empresa.getAdminEmail()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<EmpresaProjection> findById(@PathVariable Long codigo){
        EmpresaProjection empresa = carregarEmpresaUC.buscarPorCodigo(codigo);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        }
        return ResponseEntity.notFound().build();
    }
}
