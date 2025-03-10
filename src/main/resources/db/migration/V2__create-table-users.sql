CREATE TABLE users (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    date_created DATE DEFAULT CURRENT_DATE,
    date_updated DATE DEFAULT CURRENT_DATE,
    role TEXT NOT NULL
);
