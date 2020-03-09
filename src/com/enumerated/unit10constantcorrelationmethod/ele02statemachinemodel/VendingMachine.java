package com.enumerated.unit10constantcorrelationmethod.ele02statemachinemodel;

import com.enumerated.unit05cartoons.Generator;
import com.io.thinkinginjava.practicaltool.TextFile;

import java.util.Iterator;


public class VendingMachine {

    // 默认状态
    private static State state = State.RESTINE;
    // 当前金额
    private static int amount = 0;
    // 选择的商品
    private static Input selection = null;
    // 瞬时状态
    enum StateDuration { TRANSIENT };
    // 状态枚举
    enum State {
        // 初始界面
        RESTINE {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    // 投币，则金额添加，并且状态改为选择商品
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    // 退出则状态修改为交易终止
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                    default:
                }
            }
        },
        // 选择商品
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    // 投币则添加金额
                    case MONEY:
                        amount += input.amount();
                        break;
                    // 购买商品，则将商品信息存储，并判断金额是否足够，
                    // 不够则提示Insufficient mony for selection，
                    // 足够则将状态修改为发出商品交易成功
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("Insufficient mony for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    // 放弃交易，状态修改为找零
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    // 退出则状态修改为交易终止
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                    default:
                }
            }
        },
        // 发出商品 交易成功
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            void next() {
                // 输出提示信息，减去商品价格，并将状态修改为找零
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        // 找零
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            void next() {
                // 如果金额大于0， 退币，并将当前金额设置为0
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                // 状态修改为初始状态
                state = RESTINE;
            }
        },
        // 交易终止
        TERMINAL {
            void output() {
                System.out.println("Halted");
            }
        };

        // 当前为瞬时状态？ 默认false
        private boolean isTransient = false;

        State() {}

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for StateDuration.TRANSIENT states");
        }

        void output() {
            System.out.println(amount);
        }
    }

    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        gen = new FileInputGenerator("StateMachineModel.txt");
        run(gen);
    }

}

/**
 * gen.next 得到下一个input对象
 */
class RandomInputGenerator implements Generator<Input> {
    @Override
    public Input next() {
        return Input.randonSelection();
    }
}

/**
 * 文件输出类
 */
class FileInputGenerator implements Generator<Input> {
    // 字符串迭代器
    private Iterator<String> input;

    // 构造方法
    public FileInputGenerator(String fileName) {
       input = new TextFile(fileName, ";").iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext()) {
            return null;
        }
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
