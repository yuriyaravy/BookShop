package com.senla.bookshop.utils.web;

import java.util.Date;

import org.apache.log4j.Logger;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.senla.bookshop.entity.User;

public class TokenHandler {

	private final static Logger LOGGER = Logger.getLogger(TokenHandler.class);
	private final static String NAME = "name";
	private final static String PASSWORD = "password";

	private static TokenHandler instance;

	public static TokenHandler getInstance() {
		if (instance == null) {
			instance = new TokenHandler();
		}
		return instance;
	}

	public String generateToken(String name, String password) {
		try {
			byte[] key = new byte[32];
			JWSSigner singer = new MACSigner(key);
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().issuer(null)
					.expirationTime(new Date(new Date().getTime() + 60 * 1000)).claim(NAME, name)
					.claim(PASSWORD, password).build();

			SignedJWT jwt = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
			jwt.sign(singer);
			return jwt.serialize();
		} catch (JOSEException e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	public String extractToken(User token) {
		return TokenStorage.getInstance().getToken(token);
	}

}
