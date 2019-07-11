package life.sanelee.community.Controller;

import life.sanelee.community.DTO.AccessTokenDTO;
import life.sanelee.community.DTO.GithubUser;
import life.sanelee.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("930c2be4fd3db31f2f22");
        accessTokenDTO.setClient_secret("8218e09502553a1453eab59d94673f250133449f");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:9090/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
