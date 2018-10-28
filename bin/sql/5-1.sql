CREATE TABLE IF NOT EXISTS player(
    player_id MEDIUMINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
	team_id MEDIUMINT NOT NULL,
	FOREIGN KEY(team_id) REFERENCES team(team_id)
);