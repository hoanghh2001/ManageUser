package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("DB_URL=" + System.getenv("DB_URL"));
        System.out.println("DB_USER=" + System.getenv("DB_USER"));
        SpringApplication.run(Application.class,args);
    }
}