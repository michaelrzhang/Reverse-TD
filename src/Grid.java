public abstract class Grid{
	String name;
	double x_position;
	double y_position;
	boolean can_move;
	boolean can_place;
	UI ui;
	Tower tower;
	Grid[] adjacent;
	Creature[] creatures;
	Projectile[] projectiles;

}