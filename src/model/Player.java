package model;

public class Player {
    private Integer id; //선수 ID(player_id)를 저장할 변수를 선언한다.
    private String name; //선수명(name)을 저장할 변수를 선언한다. 
    private Team team; //팀 ID(team_id)를 저장할 변수를 선언한다.
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
}
