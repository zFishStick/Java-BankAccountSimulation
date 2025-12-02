# ⚗️ Controlled Experiment

You have just been hired as a software developer to maintain a banking system.
The previous developer left no documentation, and some parts of the codebase contain ambiguous variable names and inconsistent method naming conventions.

## 🪶 Survey
Before proceeding with the experiment, each participant has to complete the following [survey](https://forms.gle/S5XUBUepJhCz1Mb27).

## 🧠 Activity
Your task is to analyze the `BankAccount` class, understand the purpose of each function, and document your answers in the Google Form “Bank System – Answers” provided [here](https://forms.gle/Jb1kgknta1V3mnr1A).

For each function, you must provide:
- A short description of what the function does (its purpose).
- Whether you think the function requires comments or not.

Your goal is not to rewrite the code, but to understand it and assess whether comments would improve its readability.

### **Example format**
```java
public double applyDiscount(double amount, boolean isPremium) {
    if (isPremium) {
        amount = amount * 0.9;
    }
    return amount;
}

```
**Function purpose**: Applies a discount to the given amount if the customer is a premium member, otherwise returns the original amount.
***Needs comments?*** No

Some functions may be straightforward and self-explanatory, while others might be complex and benefit from additional comments. Your insights will help improve the codebase for future developers.

Good luck!
