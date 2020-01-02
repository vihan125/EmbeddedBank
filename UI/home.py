from flask import Flask, escape, request,render_template

app = Flask(__name__)

@app.route('/')
def hello():
    return render_template('home.html')

@app.route('/about')
def about():
    return "<h1>About Page</h1>"

@app.route('/createuser')
def createuser():
    return render_template('createuser.html')

@app.route('/addaccount')
def addaccount():
    return render_template('addaccount.html')

@app.route('/stats')
def stats():
    return render_template('stats.html')
    
if __name__=='__main__':
    app.run(debug=True)