CREATE TABLE IF NOT EXISTS tbl_user (
    id SERIAL PRIMARY KEY,
    login VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(128) NOT NULL,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS tbl_marker (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS tbl_issue (
    id SERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES tbl_user(id),
    title VARCHAR(64) UNIQUE NOT NULL,
    content VARCHAR(2048) NOT NULL,
    created TIMESTAMP,
    modified TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tbl_issue_marker (
    issue_id BIGINT REFERENCES tbl_issue(id),
    marker_id BIGINT REFERENCES tbl_marker(id),
    PRIMARY KEY (issue_id, marker_id)
);

CREATE TABLE IF NOT EXISTS tbl_message (
    id SERIAL PRIMARY KEY,
    issue_id BIGINT REFERENCES tbl_issue(id),
    content VARCHAR(2048) NOT NULL
);
