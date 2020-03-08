package com.enumerated.unit10constantcorrelationmethod.ele01chainofresponsibility;

/**
 * 职责链模式：邮局模型
 *
 * 通过多种状态对邮件进行判断，得到当前邮件的状态
 */
public class PostOffice<MACHINE_SCAN> {

    enum MailHandler {
        GENERAL_DELIVERY{ // 邮件的存局候领处验证：YES则终止执行
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN { // 扫描验证：UNSCANNABLE则正常
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default: // 其他情况验证地址信息
                        switch (m.address) {
                            case INCORRECT:return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION { // 可读性验证：INCORRECT则正常
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default: // 其他情况验证address信息
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER { // 验证收货地址信息
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + m + " to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    };

    /**
     * 遍历所有判断，输出邮件当前状态
     * @param m
     */
   static void handle(Mail m) {
       for (MailHandler handler : MailHandler.values()) {
           if (handler.handle(m)) {
               return;
           }
       }
       System.out.println(m + " is a dead letter");
   }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("--------------------------------------------------");
        }
    }
}
