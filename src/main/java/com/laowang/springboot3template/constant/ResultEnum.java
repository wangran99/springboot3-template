package com.laowang.springboot3template.constant;

/**
 * 错误码
 */
public enum ResultEnum implements IResult {
    SUCCESS(200, "操作成功"),
    UNAUTHORIZED(401, "未登录或登录过期"),
    TOO_MANY_REQUESTS(403, "连接的用户过多"),
    INTERNAL_SERVER_ERROR(500, "内部服务器错误"),

    //    以下是具体的业务相关错误码
    SYSTEM_BUSY(500001, "系统繁忙，请稍候再试"),
    OPERATION_ERRO(500002, "操作失败"),
    VERIFICATION(400000, "验证码有误"),
    TOKEN_ERROR(401001, "登录凭证已过期，请重新登录"),
    DATA_ERROR(401003, "传入数据异常"),
    NOT_ACCOUNT(401004, "该用户不存在,请先注册"),
    USER_LOCK(401005, "该用户已被锁定，请联系运营人员"),
    PASSWORD_ERROR(401006, "用户名或密码错误"),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(401007, "方法参数校验异常"),
    UNAUTHORIZED_ERROR(401008, "权鉴校验不通过"),
    ROLE_PERMISSION_RELATION(401009, "该菜单权限存在子集关联，不允许删除"),
    OLD_PASSWORD_ERROR(401010, "旧密码不正确"),
    NOT_PERMISSION_DELETED_DEPT(401011, "该组织机构下还关联着用户，不允许删除"),
    OPERATION_MENU_PERMISSION_CATALOG_ERROR(401012, "操作后的菜单类型是目录，所属菜单必须为默认顶级菜单或者目录"),
    OPERATION_MENU_PERMISSION_MENU_ERROR(401013, "操作后的菜单类型是菜单，所属菜单必须为目录类型"),
    OPERATION_MENU_PERMISSION_BTN_ERROR(401013, "操作后的菜单类型是按钮，所属菜单必须为菜单类型"),
    OPERATION_MENU_PERMISSION_URL_NOT_NULL(401015, "菜单权限的url不能为空"),
    OPERATION_MENU_PERMISSION_URL_PERMS_NULL(401016, "菜单权限的标识符不能为空"),
    THE_UNIT_HAS_ASSOCIATION_INFORMATION(401016, "该单位下存在关联信息，不允许删除"),

    COMPANY_NAME_IS_EXIST(401017, "公司名称已存在"),
    USER_NAME_IS_EXIST(401018, "登录账号已存在"),
    PASSWORD_IS_BLANK(401019, "密码不能为空"),
    TWO_DIFFERENT_PASSWORD(401020, "两次密码输入不同"),
    ORIGINAL_PASSWORD_ERROR(401021, "原密码错误"),
    OLD_PASSWORD_IS_BLANK(401022, "原密码不能为空"),
    NEW_PASSWORD_IS_BLANK(401023, "新密码不能为空"),

    DICT_NAME_NOT_NULL(401100, "字典名称不能为空"),
    DICT_NAME_IS_EXIST(401101, "字典名称已存在"),

    DICT_DETAIL_VALUE_NOT_NULL(401102, "字典值不能为空"),
    DICT_DETAIL_VALUE_IS_EXIST(401103, "字典名称-字典值已存在");

    private Integer code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "Result { code=" + this.code + ", message=" + this.message + "}";
    }
}