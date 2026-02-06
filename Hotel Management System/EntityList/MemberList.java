package EntityList;
import Entity.*;
import Interfaces.*;

public class MemberList implements iMemberList {
    private Member mem[];

    public MemberList() {
        mem = new Member[100];
    }

    public MemberList(int size) {
        mem = new Member[size];
    }

    public void insert(Member m) {
        boolean flag = false;
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == null) {
                mem[i] = m;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Successfully Inserted");
        } else {
            System.out.println("Failed to Insert");
        }
    }

    public Member getByNID(String nid) {
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] != null) {
                if (mem[i].getNID().equals(nid)) {
                    return mem[i];
                }
            }
        }
        return null;
    }

    public void deleteByNID(String nid) {
        boolean flag = false;
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] != null) {
                if (mem[i].getNID().equals(nid)) {
                    mem[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Deletion Successful");
        } else {
            System.out.println("Deletion Failed");
        }
    }

    public void searchByName(String name) {
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] != null) {
                if (mem[i].getName().equals(name)) {
                    System.out.println("+++ Found +++");
                    mem[i].showInfo();
                    return;
                }
            }
        }
        System.out.println("-- Not Found ---");
    }

    public String getAll() {
        String allMemberInfo = "";
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] != null) {
                allMemberInfo += "_______________________________________________________________________________________________________\n";
                allMemberInfo += mem[i].getMemberInfoAsString();
            }
        }
        allMemberInfo += "___________________________________________________________________________________________________________\n";
        return allMemberInfo;
    }
}