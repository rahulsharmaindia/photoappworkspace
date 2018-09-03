create table Album_Data (
	album_id INTEGER not null primary key,
	album_name VARCHAR(75) null,
	album_path VARCHAR(75) null,
	creation_date DATE null,
	created_by VARCHAR(75) null,
	shared_with VARCHAR(75) null,
	access_ INTEGER
);