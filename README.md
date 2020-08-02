#### 项目说明

### 类型转换（String-Date）

- 之前使用的是

### 方法级别权限控制

- 注解

  - @RolesAllowed: 表示访问对应方法时应该具有的角色

  - @PermitAll : 表示允许所有的角色进行访问

    - 以上两个都需要在Spring-Security.xml中开启jsr-250注解，并且在pom.xml中导入依赖

  - @Secured: 和@RolesAllowed一样，需要在Spring-Security.xml开启

  - ````xml
       <security:global-method-security jsr250-annotations="enabled" secured-annotations="enabled"/>
    ````

    - 第一个是上面两个注解的开启，第二个是secured注解的开启

  - 代码示例

    - ````java
       /**
           * create by: gb
           * description: 查询全部产品
           * create time: 2020/7/28 14:52
           *
           * @param
           * @return
           */
          @RolesAllowed("ADMIN")
          @Secured("ROLE_ADMIN")
      /** 这两个效果一样，都是表示这只有ADMIN权限的用户才能浏览该页面，但不同的是，Secured需要有前缀，RolesAllowed不需要 */
          @RequestMapping("/findAll.do")
          public ModelAndView findAll() {
              ModelAndView modelAndView = new ModelAndView();
              List<Product> products = productService.findAll();
              modelAndView.addObject("productList", products);
              modelAndView.setViewName("all-admin-datalist");
              return modelAndView;
      
          }
      
      ````

    - 

