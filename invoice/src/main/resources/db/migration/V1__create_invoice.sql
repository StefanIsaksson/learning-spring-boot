CREATE TABLE INVOICE(
                        	ID TEXT PRIMARY KEY NOT NULL UNIQUE,
                        	INVOICE_NUMBER TEXT NOT NULL UNIQUE,
                        	CLIENT_NAME TEXT NOT NULL,
                        	CLIENT_ADRESS TEXT NOT NULL,
                        	INVOICE_TOTAL REAL NOT NULL,
                        	INVOICE_DATE TEXT NOT NULL,
                        	DUE_DATE TEXT NOT NULL,
							PDF_FILE_NAME TEXT
                        );