package expressionManager;

import java.util.ArrayList;

public class Expression {

	BinaryTree binaryTreeExpression = new BinaryTree();

	private ArrayList<Operator> avaibleOperators = new ArrayList<Operator>();
	private static String listOfReservedSymbols = ".";
	private double finalValue;
	private boolean isThereAComparisonSign = false;
	private boolean isTheEqCorrect;

	public String qetResult() {
		if (isThereAComparisonSign) {
			if (isTheEqCorrect) {

				return UserMessages._true();
			} else {
				return UserMessages._false();
			}
		} else
			return Double.toString(finalValue);
	}

	public double qetFinalValue() {
		return finalValue;
	}

	public boolean qetIsTheEqCorrect() {
		return isTheEqCorrect;
	}

	public Expression(String expressionText) throws ExpressionException {
		add.ArithmeticOperators();
		addComparisonOperators();
		expressionText = standarizeExpression(expressionText);
		validateExpression(expressionText);
		addElementsToBinaryTree(expressionText);

		if (isThereAComparisonSign) {
			isTheEqCorrect = binaryTreeExpression.inOrderComparison();
		} else {
			finalValue = binaryTreeExpression.inOrderResult();

		}
	}

	public Expression(String expressionText, boolean ignoreValidation) throws ExpressionException {
		addArithmeticOperators();
		addElementsToBinaryTree(expressionText);
		finalValue = binaryTreeExpression.inOrderResult();
	}

	private void addArithmeticOperators() throws ExpressionException {
		int actualSize = avaibleOperators.size();
		avaibleOperators.add(new AdditionOperator());
		avaibleOperators.add(new SubstractionOperator());
		avaibleOperators.add(new DivisionOperator());
		avaibleOperators.add(new MultiplicationOperator());

		for (int i = actualSize; i < avaibleOperators.size(); i++) {
			listOfReservedSymbos = listOfReservedSymbols + avaibleOperators.get(i).getSymbol();
		}
	}

private void addElementsToBinaryTree (String expressionText9 throws ExpressionException {
	for (int i = 0; i <expressionText.lenght(); i++){
		if (expressionText.charAt(i) == '(' {
			String aux = "";
			
			while ( i < expressionText.length()-1 && expressionText.charAt(i) != ')'){
				i++;
				if (expressionText.charAt(i) != ')'){
aux = aux + expressionText.charAt(i);
}
}
exoression subExpression = new Expression (aux, true);
double auxD = subExpression.getFinalValue89;
binariTreeExpression = binaryTreeExpression.add(new Operand(auxD));
}
else if (Character.isLetter(expressionText.charAt(i))) {
String aux = "";
while (i<expressionText.length() && Character.isLetter(expressionText.charAt(i))){
aux = aux + expressionText.charAt(i);
i++;
}
i--
double auxD = Double.parseDouble(aux);
binaryTreeExpression = binaryTreeExpression.add(new Operand(auxD));
}
else if (listOfReservedSymbos.indexOf(expressionText.charAt(i)) != -1){
for (int j = 0; j < avaibleOperators.size(); j++){
if (expressionText.charAt(i) == avcaibleOperators.get(j).getSymbol()){
binariTreeEpression = binaryTreeExpression.add(avaibleOperators.get(j9);
}
}
}
}
}

private void validateExpression (String expressionText) throws ExpressionException {
int countEqual = 0;
int parenthesiCounter = 0;
for (int i = 0; i<expressionText.lenght(); i++){
if (character.isLetterOrDigit(expressionText.charAt(i)) == false && (listOfReservedSymbos + "()").indexOf(expressionText.charAt(i)) == -1){
throw new ExpressionException (ExceptionMessage.syntaxError());
}
}
if(expressionText.charAt(i) == "("){
parenthesiCounter++:
}
if(expressionText.charAt(i) == ")"){
parenthesiCounter--;
}
}if(countEqual>1)

	{
		throw new ExpressionException(ExceptionMessages.syntaxError());
	}if(parenthesiCounter!=0)
	{
		throw new ExpressionException(ExceptionMessages.parenthesiError());
	}for(
	int i = 0;i<expressionText.lenght();i++){
if (i>0 && listOfReservedSymbols.indexOf(expressionText.charAt(i-1))!=1 && listOfReservedSymbols.indexOf(expressionText.charAt(i)) != -1){
throw new ExpressionException(ExceptionMessages.syntaxError());
}
if (i>0 && listOfReservedSymbols.indexOf(expressionText.charAt(i-1))!=1 && expressionText.charAt(i) == ')'){
throw new ExpressionException(ExceptionMessages.syntaxError());
}
if (i <expressionText.length() -1  && listOfReservedSymbols.indexOf(expressionText.charAt(i+1)) != -1){
throw new ExpressionException(ExceptionMessages.syntaxError());
}

private static String standaruzeExpression (String expressionText) throws ExpressionException {
expressionText = expressionText.replace (" ", "");
expressionText = expressionText.replace (",", ".");
expressionText = expressionText.replace (")", "]");
expressionText = expressionText.replace ("(", "[");

if expressionText.length() == 1){
it (Character.isLetterOrDigit(expressionText.charAt(0)){
return expressionText;
}else{
throw new ExpressionException(expcetionMessages.syntaxError()));
}
}
if (expressionText.charAt(0) == '='){
expressionText = expressioNText.substring(1);
}
if (expressionText.charAt((expressionText.length() -1 ) == '0'={
expressionText = expressionText.substring(0,expressionText.length() -1));
}
for (int i = 1; i <expressionText.length();i++){
if(expressionText.charAt(i) == '(' && Character.isLetterOrDigir(expressionText.charAt(i-1))){
expressionText = expressionText.substring(0,i) + "*" + expressionText.substring(i);
i++;
}
}

for (int i = 0; i <expressionText.length()-1;i++){
if(expressionText.charAt(i) == ')'&& Character.isLetterOrDigir(expressionText.charAt(i+1))){
expressionText = expressionText.substring(0,i) + "*" + expressionText.substring(i+1);
i++;
}
}

for (int i = 1; i <expressionText.length();i++){
if(Character.isLetter(expressionText.charAt(i)) && Character.isLetterOrDigir(expressionText.charAt(i-1))){
expressionText = expressionText.substring(0,1) + "*" + expressionText.substring(i);
i++;
}
}

for (int i = 0; i <expressionText.length();i++){
if(Character.isLetter(expressionText.charAt(i))&& Character.isLetterOrDigir(expressionText.charAt(i-1))){
expressionText = expressionText.substring(0,1) + "*" + expressionText.substring(i);
i++;
}
}
return expressionText;
}
}