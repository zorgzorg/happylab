package kz.epam.happylab.action;

import static kz.epam.happylab.util.Constant.*;

public abstract class ActionFactory {

    public static Action getAction(String action){

        if(LOGIN.equalsIgnoreCase(action)){
            return new LoginAction();
        }
        if(LOGOUT.equalsIgnoreCase(action)){
            return new LogoutAction();
        }
        if(EDIT.equalsIgnoreCase(action)){
            return new EditAction();
        }
        if(ADD.equalsIgnoreCase(action)){
            return new AddAction();
        }
        if(APPLY.equalsIgnoreCase(action)){
            return new ApplyAction();
        }
        if(SAVE.equalsIgnoreCase(action)){
            return new SaveAction();
        }
        if(SAVE_ASSISTANT.equalsIgnoreCase(action)){
            return new SaveAssistantAction();
        }
        if(SAVE_SIGNATURE.equalsIgnoreCase(action)){
            return new SaveSignatureAction();
        }
        if(BLOCK.equalsIgnoreCase(action)){
            return new BlockAction();
        }
        if(DELETE.equalsIgnoreCase(action)){
            return new DeleteAction();
        }

        return new ShowAction();
    }
}
