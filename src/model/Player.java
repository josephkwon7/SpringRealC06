package model;

public class Player {
    private Integer id; //���� ID(player_id)�� ������ ������ �����Ѵ�.
    private String name; //������(name)�� ������ ������ �����Ѵ�. 
    private Team team; //�� ID(team_id)�� ������ ������ �����Ѵ�.
    
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
