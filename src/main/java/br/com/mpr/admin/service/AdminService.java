package br.com.mpr.admin.service;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.properties.MprAdminProperties;
import br.com.mpr.admin.utils.ObjectUtils;
import br.com.mpr.admin.utils.RestUtils;
import br.com.mpr.admin.vo.FornecedorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wagner on 7/21/18.
 */
@Service
public class AdminService {

    @Autowired
    private MprAdminProperties properties;


    public List<FornecedorVo> getAllFornecedor() throws RestException {
        return Arrays.asList(
                RestUtils.getJsonWithParamPath(
                        FornecedorVo[].class,properties.getWsApi(),"api/v1/admin/FornecedorEntity/all"));
    }

    public FornecedorVo getFornecedorById(Long id) throws RestException {
        return RestUtils.getJsonWithParamPath(
                        FornecedorVo.class,properties.getWsApi(),"api/v1/admin/FornecedorEntity", id.toString());

    }

    public FornecedorVo saveFornecedor(FornecedorVo fornecedorVo) throws RestException {
        return RestUtils.postJson(FornecedorVo.class,
                properties.getWsApi(),"api/v1/admin/FornecedorEntity/save",
                ObjectUtils.toJson(fornecedorVo));

    }
}
