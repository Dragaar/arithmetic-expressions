package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {return value;}
            @Override
            public String toExpressionString() {
                if(value < 0)  return "(" + value +")";
                return Integer.toString(value);
            }
        };
    }

    public static Expression sum(Expression... members){

        return new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for(Expression e : members)
                    sum += e.evaluate();
                return sum;
            }

            @Override
            public String toExpressionString() {
                StringBuffer sb = new StringBuffer("(");
                for(int i = 0; i <= members.length-2; i++) {
                    sb.append(members[i].toExpressionString())
                      .append(" + ");
                }
                    sb.append(members[members.length-1].toExpressionString())
                      .append(")");
                return sb.toString();
            }
        };
    }

    public static Expression product(Expression... members){

        return new Expression() {
            @Override
            public int evaluate() {
                int product = members[0].evaluate();
                for(int i = 1; i < members.length; i++)
                    product *= members[i].evaluate();
                return product;
            }

            @Override
            public String toExpressionString() {
                StringBuffer sb = new StringBuffer("(");
                for(int i = 0; i <= members.length-2; i++) {
                    sb.append(members[i].toExpressionString())
                            .append(" * ");
                }
                sb.append(members[members.length-1].toExpressionString())
                        .append(")");
                return sb.toString();
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate()-subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+minuend.toExpressionString()+" - "+subtrahend.toExpressionString()+")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        //implement this method
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {

                return "("+dividend.toExpressionString()+" / "+divisor.toExpressionString()+")";
            }
        };
    }

}
