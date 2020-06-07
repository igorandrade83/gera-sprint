package blockly;

import cronapi.CronapiMetaData;
import cronapi.Utils;
import cronapi.Var;
import cronapi.*;
import java.util.concurrent.Callable;
import cronapi.CronapiMetaData.CategoryType;
import cronapi.CronapiMetaData.ObjectType;	
import cronapi.ParamMetaData;
import cronapi.rest.security.CronappSecurity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Igor Andrade
 * @version 1.0
 * @since 2020-06-07
 *
 */
 
@CronapiMetaData(type = "blockly", categoryName = "URL") 
@CronappSecurity
public class URLEncodeDecode {

public static final int TIMEOUT = 300;

	/**
	*
	* @param url
	* @return Var
	*/
	//URLEncodeDecode
	@CronapiMetaData(type = "function", name = "URI encode", description = "Codifica URIs")
	public static Var encode(Var url) throws Exception {
		return new Callable<Var>() {
			public Var call() throws Exception {
				try {
					
					return Var.valueOf(URLEncoder.encode( url.toString(), "UTF-8" ));
				} catch (UnsupportedEncodingException e) {
					return Var.valueOf("Problema ao codificar: " + e.getMessage());
				}
			}
		}.call();
	}

	/**
	*
	* @param url
	* @return Var
	*/
	@CronapiMetaData(type = "function", name = "URI decode", description = "Decodifica URIs")
	public static Var decode(Var url) throws Exception {
		return new Callable<Var>() {
			public Var call() throws Exception {
				Var prevURL = Var.VAR_NULL;
				Var decodeURL = Var.valueOf(url);

				try {
					while(!prevURL.equals(decodeURL)){
						prevURL=decodeURL;
						decodeURL=Var.valueOf(URLDecoder.decode( decodeURL.toString(), "UTF-8"));
					}
					return Var.valueOf(decodeURL);
				} catch (UnsupportedEncodingException e) {
					return Var.valueOf("Problema ao decodificar: " +e.getMessage());
				}
			}
		}.call();
	}
}


