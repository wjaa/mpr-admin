package br.com.mpr.admin.service;

import br.com.mpr.admin.vo.FornecedorVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wagner on 7/21/18.
 */
@Service
public class AdminService {

    public List<FornecedorVo> getAllFornecedor(){
        List<FornecedorVo> list = new ArrayList<>();
        for (long i = 0; i < 10; i++){
            FornecedorVo f = new FornecedorVo();
            f.setId(i);
            f.setCnpj("10000000000" + i);
            f.setTelefonePrincipal("456456456" + i);
            f.setEmail("wag182@gmail.com");
            f.setNome("Fornecedor" + i);
            f.setAtivo(true);
            f.setEndereco("rua emilio ribas");
            list.add(f);

        }
        return list;
    }

    public FornecedorVo getFornecedorById(Long id) {
        FornecedorVo f = new FornecedorVo();
        f.setId(id);
        f.setCnpj("10000000000" + id);
        f.setTelefonePrincipal("456456456" + id);
        f.setEmail("wag182@gmail.com");
        f.setNome("Fornecedor" + id);
        f.setAtivo(true);
        f.setEndereco("rua emilio ribas");
        return f;
    }
}
