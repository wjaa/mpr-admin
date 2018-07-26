package br.com.mpr.admin.exception;

import br.com.mpr.admin.vo.ErrorMessageVo;

/**
 * Created by wagner on 7/18/18.
 */
public class RestException extends Throwable {
    private ErrorMessageVo errorMessageVo;

    public RestException(ErrorMessageVo errorMessageVo) {
        this.errorMessageVo = errorMessageVo;
    }

    public RestException(int errorCode, String errorMessage) {
        this.errorMessageVo = new ErrorMessageVo(errorCode,errorMessage);
    }
}
