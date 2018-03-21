package com.senla.bookshop.utils.web;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class TokenHandler {
	
	private final static Logger LOGGER = Logger.getLogger(TokenHandler.class);
	
	private static TokenHandler instance;
	
	public static TokenHandler getInstance() {
		if (instance == null) {
			instance = new TokenHandler();
		}
		return instance;
	}
	
	public String generateToken(Integer id) {
		try {
			byte[] key = new byte[32];
			JWSSigner singer = new MACSigner(key);
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().issuer("userName")
					.expirationTime(new Date(new Date().getTime() + 60 * 1000))
					.claim("id", id)
					.build();
			
			SignedJWT jwt = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
			jwt.sign(singer);
			return jwt.serialize();
		} catch ( JOSEException e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}
	
	private Boolean checkToken(String token) {
		try {
			byte[] key = new byte[32];
			SignedJWT jwt = SignedJWT.parse(token);
			JWSVerifier jwsVer = new MACVerifier(key);
			jwt.verify(jwsVer);
			return true;
		}catch (JOSEException | ParseException e)  {
			LOGGER.error(e.getMessage());
			return false;
		}
	}
	
	public Integer extractToken(String token) {
		if(this.checkToken(token)) {
			try {
				SignedJWT jwt = SignedJWT.parse(token);
				return (Integer) jwt.getJWTClaimsSet().getClaim("id");
			}catch(ParseException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return null;
	}

}
