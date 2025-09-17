package com.gamingroom;

/**
 * A abstract class for game
 * 
 * @author william.paddock@snhu.edu
 *
 */
public class Entity {
        // Build the entity abstract class
        long id;
        String name;

        /**
         * Hide the default constructor to prevent creating empty instances.
         */
        private Entity() {
        }

        /**
         * Constructor with an identifier and name
         */
        public Entity(long id, String name) {
                this();
                this.id = id;
                this.name = name;
        }

        /**
         * @return the id
         */
        public long getId() {
                return id;
        }

        /**
         * @return the name
         */
        public String getName() {
                return name;
        }

        /**
         * @return the game id and name for print
         */
        @Override
        public String toString() {
                return "Entity [id=" + id + ", name=" + name + "]";
        }

}

