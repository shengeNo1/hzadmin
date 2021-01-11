package org.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName LombokPlugin.java
 * @Description TODO
 * @createTime 2021年01月03日 11:50:00
 */

public class LombokPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addImportedType("lombok.ToString");
        topLevelClass.addAnnotation("@ToString");
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @author LYS liuyua776@gmail.com");
        topLevelClass.addJavaDocLine("* Created by Mybatis Generator " + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        topLevelClass.addJavaDocLine("*/");
        return true;
    }

//    @Override
//    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
//                                   IntrospectedTable introspectedTable) {
//
//        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Repository")); //$NON-NLS-1$
//        interfaze.addAnnotation("@Repository"); //$NON-NLS-1$
//        return true;
//    }
}
