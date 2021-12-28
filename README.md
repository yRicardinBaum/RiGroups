
## Inicialização
Esta API utiliza 2 APIs importantes, cujo tenho que apresenta-las:

- Spigot (1.8)
- Lombok (1.18.22)  


Para começarmos, vamos adicionar a API em seu projeto!


## Gradle
```groovy
repositories {
        mavenCentral()
        maven { url = 'https://jitpack.io/' }
}
dependencies {
    implementation 'com.github.yRicardinBaum:RiGroups:v1.5'
}
```

## Maven
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
             <dependency>
            <groupId>com.github.yRicardinBaum</groupId>
            <artifactId>RiGroups</artifactId>
            <version>v1.5</version>
        </dependency>
     </dependencies>
```



## Utilização

Para começar, vamos criar a instancia do Group. 


```java
public class Main extends JavaPlugin {
    @Getter
    private Main instance;

    @Override
    public void onEnable() {
        // CARREGANDO CONFIG.YML
    saveDefaultConfig();
    // CARREGANDO CARGOS
     new GroupStarter(this.getInstance(), this.getConfig(), this.getConfig().getConfigurationSection("cargos"));
     // LOGGER DE SUCESSO
     this.getInstance().getLogger().info("Cargos carregados com sucesso!");
    }
}
```

Lembrando que o modelo da config.yml tem que ser algo parecido com isso: 

```yaml

cargos:
  dono:
    Nome: "Dono"
    Prefix: "&d&lDONO&d "
    Permissao: "role.dono"
    broadcast_lobby: true
  gerente:
    Nome: "Gerente"
    Prefix: "&c&lGERENTE&c "
    Permissao: "role.gerente"
    broadcast_lobby: true
  membro:
    Nome: "Membro"
    Prefix: "&7"
    Permissao: ""
    broadcast_lobby: true

```
Abaixo estarei fazendo um LOGGER com todos os cargos:

```java
for(Group gp : GroupManager.getGroups()) {
         this.getInstance().getLogger().info("Name: " + gp.getRoleName() + ", Permission: " + gp.getPermission() + ", Prefix: " + gp.getPrefix() + ", Priority: " + gp.getPriority());
     }
```


E pronto, API finalizada, qualquer dúvida podem entrar em contato comigo: [yRicardinBaum](https://discordapp.com/users/409801761470152704)
