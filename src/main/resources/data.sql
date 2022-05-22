# Init roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_MODERATOR');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

# Init users
INSERT INTO users (email, password, username) VALUES ('chieesnddafo@gmail.com', '$2a$10$iCDLUsBEpOkLhq2iSrgdceAcNru1C/LMJ5eBVYEUATP.OAZTgucje', 'chieesnddafo');
INSERT INTO users (email, password, username) VALUES ('chiendao13092001@gmail.com', '$2a$10$m0BWedC4Dal0NLZvBuEppOMyVKtHhGLRgSQG4D1uK/yML.Zvw.FLK', 'chieesnddafo1');
INSERT INTO users (email, password, username) VALUES ('aaaa@gmail.com', '$2a$10$gkM0uUGE9I7EEbm.aBoffOs8wDjBqQ03d1.2/zm6BTvCAZ1Y56AlK', 'chienne123');

# Init user_roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 1);


# Init tutorials
INSERT INTO tutorials (content, expected, title, short_description) VALUES ('CONTENT1', 'true', 'TITLE1', 'Nice Array');
INSERT INTO tutorials (content, expected, title, short_description) VALUES ('helloworld', '6', 'helloworld', 'Hello World');
INSERT INTO tutorials (content, expected, title, short_description) VALUES (null, '1234', null, null);

# Init solutions
INSERT INTO solutions (created_at, details, tutorial_id, user_id) VALUES ('2022-04-25 07:49:46', 'import java.util.*;

public class Kata{
    public static void main (String[] args) {
      Integer[] arr = new Integer[]{1,2,3,4,5};
      boolean isNiceArr = isNice(arr);
      System.out.println(isNiceArr);
    }

    public static boolean isNice(Integer[] arr){
        return true;
    }
}', 1, 2);
INSERT INTO solutions (created_at, details, tutorial_id, user_id) VALUES ('2022-05-15 11:18:36', 'public class ehhe{
    public static void main(String[] args){
       System.out.println("true");
 }
}
', 1, 1);
INSERT INTO solutions (created_at, details, tutorial_id, user_id) VALUES ('2022-05-15 11:44:50', 'public class test{
     public static void main(String[] args){
       System.out.println("true");
   }
}', 1, 1);
INSERT INTO solutions (created_at, details, tutorial_id, user_id) VALUES ('2022-05-15 11:45:01', 'public class toine{
   public static void main(String[] args){
       System.out.println("true");
   }
}

', 1, 1);

# init comment
INSERT INTO comments (content, created_at, tutorial_id, user_id, solution_id) VALUES ('hehehe', null, 1, 1, 4);
INSERT INTO comments (content, created_at, tutorial_id, user_id, solution_id) VALUES ('ehehehhehehe', null, 1, 1, 4);
INSERT INTO comments (content, created_at, tutorial_id, user_id, solution_id) VALUES ('????', null, 1, 2, 5);
INSERT INTO comments (content, created_at, tutorial_id, user_id, solution_id) VALUES ('dậy đi ông cháu ơi', '2022-05-15 23:28:15', 1, 1, 5);
INSERT INTO comments (content, created_at, tutorial_id, user_id, solution_id) VALUES ('Xin kiểu tóc Tommy Xiaomo', '2022-05-16 00:14:49', 1, 3, 5);
INSERT INTO comments (content, created_at, tutorial_id, user_id, solution_id) VALUES ('XIn chaooo', '2022-05-16 11:03:25', 1, 3, 4);
