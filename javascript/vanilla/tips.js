// Tip 1 - Pasar argumentos a una como un objeto
console.info("Tip 1 - object arguments");
const createUser = (username, date, isAdmin, isMod) => {
  console.log({
    username,
    date,
    isAdmin,
    isMod,
  });
  return {
    username,
    date,
    isAdmin,
    isMod,
  };
};

createUser({
  username: "admin",
  date: new Date(),
  isAdmin: true,
  isMod: false,
});

// Tip 2 - No extender prototype mejor usar clases
console.info("Tip 2 - no extend prototype");
class ArrayUtils {
  static average(list) {
    return list.reduce((acc, curr) => acc + curr, 0) / list.length;
  }
}

const list = [1, 2, 3, 4, 5];
console.log(ArrayUtils.average(list));

// Tip 3 - Pasar mensajes entre tabs y windows
console.info("Tip 3 - pass message");
const bc = new BroadcastChannel("test_channel");
bc.postMessage("Hello");
bc.onmessage = (e) => {
  console.log(e.data);
};

// Tip 4 - Crear una tuberia reutilizable
console.info("Tip 4 - reusable pipe");
const pipe =
  (...fns) =>
  (arg) =>
    fns.reduce((acc, curr) => curr(acc), arg);

const calculate = pipe(
  (value) => value * (1 - 0.03),
  (value) => value * (1 - 0.16),
  (value) => value + 3000,
  (value) => value / 3
);

const revenue = 50_000;
const profit = calculate(revenue);
console.log(profit);

// Tip 5 - Usar console trace
console.info("Tip 5 - console trace");
const some = (...args) => {
  console.trace("Log with stack trace");
  return args;
};
console.log(some(1, 2, 3));

// Tip 6 - Entender los closures
console.info("Tip 6 - closures");
const outer = () => {
  let n = 42;
  const inner = () => {
    console.log(n);
  };
  return inner;
};

const inner = outer();
inner();

// Tip 7 - Usar el operador nullish coalescing
console.info("Tip 7 - nullish coalescing");
let price_1 = 0;
let price_2 = null;
const default_price_1 = price_1 ?? 10;
const default_price_2 = price_2 ?? 5;
console.log({ default_price_1, default_price_2 });

// Tip 8- Abortar un fetch usando un controlador de errores
console.info("Tip 8 - abort controller");
console.info(
  `
const controller = new AbortController();
const signal = controller.signal;

useEffect(() => {
  fetch("https://api.github.com/users/octocat", { signal })
    .then((response) => response.json())
    .then((data) => console.log(data))
    .catch((error) => console.error(error));
  // Aborta si el componente no esta montado.  
  return () => controller.abort();
}, []);
`
);

// Tip 9 - Usar array some para revisar ocurrencias en una lista
console.info("Tip 9 - array some");
const users = [
  {
    name: "John",
    age: 30,
    active: false,
    avatar: "https://avatars0.githubusercontent.com/u/174825?v=4",
  },
  {
    name: "Jane",
    age: 20,
    active: true,
    avatar: "https://avatars0.githubusercontent.com/u/174825?v=4",
  },
  {
    name: "Bob",
    age: 25,
    active: false,
    avatar: "https://avatars0.githubusercontent.com/u/174825?v=4",
  },
  {
    name: "Jim",
    age: 35,
    active: false,
    avatar: "https://avatars0.githubusercontent.com/u/174825?v=4",
  },
  {
    name: "Jill",
    age: 32,
    active: true,
    avatar: "https://avatars0.githubusercontent.com/u/174825?v=4",
  },
];
const hasActiveUsers = users.some((user) => user.active);
console.log(hasActiveUsers);

// Tip 10 - Crear un array de solo lectura usando typescript
console.info("Tip 11 - readonly array");
console.info(
  `
const numbers: number[] = [1, 2, 3, 4, 5];
const readonlyNumbers: ReadonlyArray<number> = numbers;

readonlyNumbers[0] = 10; // error!
readonlyNumbers.push(10); // error!
readonlyNumbers.length = 100; // error!
`
);

// Tip 11 - Usar la destructuracion de objetos
console.info("Tip 11 - destructuring objects");
const countries = [
  "Argentina",
  "Bolivia",
  "Chile",
  "Colombia",
  "Ecuador",
  "Paraguay",
  "Peru",
  "Uruguay",
  "Venezuela",
];
const { 0: arg, 3: col } = countries;
console.log({ arg, col });

// Tip 12 - Hacer un scroll con el scrollIntoView
console.info("Tip 12 - scroll into view");
const element = document.getElementById("element");
element.scrollIntoView({
  behavior: "smooth",
  block: "center",
});

// Tip 13 - Usar function composition with set state
console.info("Tip 13 - function composition with set state");
console.info(
  `
const App = () => {
  const [user, setUser] = useState('');
  const [password, setPassword] = useState('');
  
  const setInput = (setter) => (e) => setter(e.currentTarget.value);
  
  return (
    <form>
      <input name="username" value={user} onChange={setInput(setUser)} />
      <input name="password" value={password} onChange={setInput(setPassword)} />
    </form>
  );
};
`
);

// Tip 14 - Usar los nombres de las variables en callbacks
console.info("Tip 14 - proper variable names");
console.info(
  `
const usersWithImages = users.filter((user) => {
  return user.entries.find((entry) => entry.type === "avatar");
});
console.log(usersWithImages);
`
);

// Tip 15 - Usar llaves en las sentencias switch
console.info("Tip 15 - curly braces on switch statements");
const getUser = (id) => {
  switch (id) {
    case 1: {
      return { name: "John" };
    }
    case 2: {
      return { name: "Jane" };
    }
    default: {
      return { name: "Unknown" };
    }
  }
};
console.log(getUser(1));

// Tip 16 - crea tus propios elementos html
console.info("Tip 16 - custom html elements");
class FooElement extends HTMLElement {
  constructor() {
    super();
    this.attachShadow({ mode: "open" });
    this.shadowRoot.innerHTML = `
      <style>
        :host {
          display: block;
          background-color: #f00;
        }
      </style>
      <slot></slot>
    `;
  }
  connectedCallback() {
    this.innerHTML = "Este es un elemento prersonalizado";
    console.log("connected");
  }
}
customElements.define("foo-element", FooElement);

// Tip 17 - Usa la inicializacion de proyectos rapidos con npm y yarn
console.info("Tip 17 - quick start with npm and yarn");
console.info(
  `
// Usando npm
npm init -y

// Usando yarn
npm i -g corepack
yarn init -2
`
);

// Tip 18 - Usar console time para medir tiempos de ejecucion
console.info("Tip 18 - console time");
console.time("time");

// Tip 19 - 3 opciones para pasar add event listener
console.info("Tip 19 - 3 event listener options");
console.info(
  `
const button = document.getElementById('button');
button.addEventListener('click', () => {
  console.log('click');
}, {
  capture: true, // will use 'capturing' instead of 'bubbling'
  once: true, // will remove the event listener after it's called
  passive: false, // will not prevent default behavior, never call preventDefault()
});
`
);

// Tip 20 - importar promesas en nodejs
console.info("Tip 20 - promises in nodejs");
console.info(
  `
const fs = require('fs/promises');
try {
  const data = await fs.readFile('file.txt', 'utf8');
  console.log(data);
} catch (error) {
  console.error(error);
}
`
);
