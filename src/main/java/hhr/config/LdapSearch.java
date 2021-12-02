package hhr.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class LdapSearch {

    private SearchControls getSimpleSearchControls() {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(30000);

        return searchControls;
    }

     private Hashtable init(){
         String url = "ldap://localhost:389";

         Hashtable env = new Hashtable();
         env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
         env.put(Context.PROVIDER_URL, url);
         env.put(Context.SECURITY_AUTHENTICATION, "simple");
         env.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
         env.put(Context.SECURITY_CREDENTIALS, "secret");

        return env;
     }


 public ArrayList findGroupsByUsername(String username) {



     ArrayList gett = new ArrayList();

     try {
         DirContext ctx = new InitialDirContext(init());
         System.out.println(ctx.getEnvironment());


         NamingEnumeration<?> namingEnum = ctx.search(
                 "ou=People,dc=maxcrc,dc=com", "(objectclass=posixGroup)",
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
