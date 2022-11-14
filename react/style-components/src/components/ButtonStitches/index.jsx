import { styled } from "../../../stitches.config"

const Button = styled('button', {
    borderRadius: '20px',
    cursor: 'pointer',
    padding: '20px',
    variants: {
        intent: {
            base: {
                color: "white",
                backgroundColor: "$gray500",
                borderWidth: '1px'
            },
            success: {
                backgroundColor: 'green',
            },
            error: {
                backgroundColor: '$redPure',
            }
        }
    },
    defaultVariants: {
        intent: 'base'
    }
})

export default function ButtonStitches () {
    return (
        <>
            <Button>ButtonStitches</Button>
            <Button intent="success">ButtonStitches</Button>
            <Button intent="error">ButtonStitches</Button>
        </>
    )
}
