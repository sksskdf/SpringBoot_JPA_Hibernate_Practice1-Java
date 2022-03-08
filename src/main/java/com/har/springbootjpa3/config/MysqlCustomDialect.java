package com.har.springbootjpa3.config;

import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MysqlCustomDialect extends MySQL57Dialect {
    public MysqlCustomDialect(){
        super();
        registerFunction(
                "CreatePreFix",
                new StandardSQLFunction("createPrefix", StandardBasicTypes.STRING)
        );
    }
}
