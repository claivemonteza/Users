package com.example.demo.access.core;

import java.util.Locale;

/**
 * Will define the language that the user will be use on the system.
 * 
 * @see Internationalized
 * 
 * @author Claive Monteza
 * 
 * @version 1.0
 * @since 1.7
 */
public enum Language implements Internationalized {
	PORTUGUESE {
		@Override
		public Locale getLocale() {
			return PORTUGUESE_LOCALE;
		}

		public String getMessageKey() {
			return "portuguese.record";
		}
	},
	ENGLISH {
		@Override
		public Locale getLocale() {
			return ENGLISH_LOCALE/*Locale.ENGLISH*/;
		}

		public String getMessageKey() {
			return "english.record";
		}
	};

	private static final Locale PORTUGUESE_LOCALE = new Locale("pt");
	private static final Locale ENGLISH_LOCALE = new Locale("en");

	/**
	 * Deve retornar o Locale para a lingua que representa
	 * 
	 * @return
	 */
	abstract public Locale getLocale();

}
