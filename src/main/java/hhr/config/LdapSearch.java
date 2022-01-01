package hhr.config;
import hhr.auth.SuccessHandlerCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.ArrayList;
import java.util.Hashtable;




@Component

public class LdapSearch  {



    private SearchControls getSimpleSearchControls() {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(30000);

        return searchControls;
    }


    @Value("${ldap.urls}")
    private String ldapUrls;

    @Value("${ldap.base.dn}")
    private String ldapBaseDn;

    @Value("${ldap.username}")
    private String ldapSecurityPrincipal;

    @Value("${ldap.password}")
    private String ldapPrincipalPassword;

    @Value("${ldap.user.dn.pattern}")
    private String ldapUserDnPattern;




     private Hashtable init(){



         Hashtable env = new Hashtable();
         env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
         env.put(Context.PROVIDER_URL, ldapUrls );
         env.put(Context.SECURITY_AUTHENTICATION, "simple");
         env.put(Context.SECURITY_PRINCIPAL, ldapSecurityPrincipal );
         env.put(Context.SECURITY_CREDENTIALS, ldapPrincipalPassword);

        return env;
     }


 public ArrayList findGroupsByUsername(String username) {



     ArrayList gett = new ArrayList();

     try {
         DirContext ctx = new InitialDirContext(init());
         System.out.println(ctx.getEnvironment());


         NamingEnumeration<?> namingEnum = ctx.search(
                 ldapBaseDn, "(objectclass=posixGroup)",
                 getSimpleSearchControls());
         while (namingEnum.hasMore()) {
             SearchResult result = (SearchResult) namingEnum.next();
             Attributes attrs = result.getAttributes();

             if (attrs.get("memberUid").contains(username)) {
                 gett.add(attrs.get("cn").toString().replace("cn: ",""));
             }

             ctx.close();
         }

     } catch (AuthenticationNotSupportedException ex) {
         System.out.println("Server not support connect");
     } catch (AuthenticationException ex) {
         System.out.println("incorrect password or username");
     } catch (NamingException ex) {
         System.out.println("context error");
     }

     return gett;
 }

}
